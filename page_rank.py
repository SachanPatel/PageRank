import numpy as np
import pandas as pd

# graph is an adjacency list. 
# graph[i] represents the outgoing links for page i

def run_page_rank(graph, d, max_iters, tol):

    N = len(graph)
    PR = [1 / N] * N
    
    dangling_pages = []
    for i, links in enumerate(graph):
        if len(links) == 0:
            dangling_pages.append(i)
    
    for i in range(max_iters):
        new_PR = [(1 - d) / N] * N

        dangling_sum = 0
        for page_idx in dangling_pages:
            dangling_sum += PR[page_idx]
        
        for j, links in enumerate(graph):
            num_links = len(links)
            if num_links > 0:
                for link in links:
                    new_PR[link] += d * PR[j] / num_links
        
        for k in range(N):
            new_PR[k] += d * dangling_sum / N

        total_diff = 0
        for p in range(N):
            total_diff += abs(new_PR[p] - PR[p])
        
        if total_diff < tol:
            break

        PR = new_PR.copy()
    
    return PR

def load_file(file_info):
    (file, idx, name, edges) = file_info

    df = pd.read_csv(file)

    mapping = dict(zip(df[idx], df[name]))
    graph = df[edges].apply(
        lambda x: [] if pd.isna(x) else list(map(int, str(x).split()))
    ).tolist()

    return mapping, graph

if __name__ == "__main__":

    files = [("cote_adjacency_indices.csv", "source_index", "source_character", "target_indices"), ("rutgers_cs_math_adjacency.csv", "index", "course_name", "outgoing_edges")]
    file = files[0]
    idx_page_map, graph = load_file(file)

    page_ranks = np.array(run_page_rank(graph, 0.85, 33, 10**-10))
    
    sorted_ranks = np.sort(page_ranks)[::-1]
    sorted_pages = np.argsort(page_ranks)[::-1]
    pages = np.vectorize(idx_page_map.get)(sorted_pages)

    df = pd.DataFrame({
        'index': sorted_pages, 
        'page': pages,
        'score': sorted_ranks
    })

    print(df.to_string(index=False))