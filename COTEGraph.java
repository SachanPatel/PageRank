import java.util.*;

public class COTEGraph {
    // characters[i] gives the character name for node i.
    public static final String[] characters = {
        "Kiyotaka Ayanokōji", // 0
        "Suzune Horikita", // 1
        "Honami Ichinose", // 2
        "Kakeru Ryūen", // 3
        "Kei Karuizawa", // 4
        "Kikyō Kushida", // 5
        "Arisu Sakayanagi", // 6
        "Yōsuke Hirata", // 7
        "Airi Sakura", // 8
        "Ken Sudō", // 9
        "Hiyori Shiina", // 10
        "Mio Ibuki", // 11
        "Manabu Horikita", // 12
        "Sae Chabashira", // 13
        "Professor Ayanokōji", // 14
        "Ichika Amasawa", // 15
        "Takuya Yagami", // 16
        "Kōhei Katsuragi", // 17
        "Miyabi Nagumo", // 18
        "Rokusuke Kōenji", // 19
        "Akane Tachibana", // 20
        "Akito Miyake", // 21
        "Albert Yamada", // 22
        "Chairman Sakayanagi", // 23
        "Chiaki Matsushita", // 24
        "Chie Hoshinomiya", // 25
        "Chihiro Shiranami", // 26
        "Haruka Hasebe", // 27
        "Haruki Yamauchi", // 28
        "Ikuto Kiriyama", // 29
        "Kanji Ike", // 30
        "Kazuomi Hōsen", // 31
        "Kyō Ishigami", // 32
        "Masayoshi Hashimoto", // 33
        "Masumi Kamuro", // 34
        "Maya Satō", // 35
        "Mei-Yu Wang", // 36
        "Nazuna Asahina", // 37
        "Ryūji Kanzaki", // 38
        "Satsuki Shinohara", // 39
        "Shirō", // 40
        "Takeko Nishino", // 41
        "Teruhiko Yukimura", // 42
        "Tomonari Mashima", // 43
        "Tsubasa Nanase", // 44
        "Yuki" // 45
    };

    // adjacencyList[i] contains the node numbers that character i points to.
    // Example: adjacencyList[0] is Kiyotaka Ayanokōji's outgoing relationship edges.
    public static final int[][] adjacencyList = {
        new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 17, 21, 23, 24, 25, 27, 35, 36, 42}, // 0 - Kiyotaka Ayanokōji
        new int[]{0, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 27}, // 1 - Suzune Horikita
        new int[]{0, 3, 5, 6, 17, 18, 25, 26, 38}, // 2 - Honami Ichinose
        new int[]{0, 1, 2, 4, 6, 10, 11, 17, 22, 31}, // 3 - Kakeru Ryūen
        new int[]{0, 1, 3, 5, 7, 8, 9, 11, 22, 27, 35, 39}, // 4 - Kei Karuizawa
        new int[]{0, 1, 2, 3, 4, 7, 8, 9, 13}, // 5 - Kikyō Kushida
        new int[]{0, 1, 2, 3, 14, 15, 17, 23, 33, 34}, // 6 - Arisu Sakayanagi
        new int[]{0, 1, 4, 5, 8, 9, 28, 35, 36}, // 7 - Yōsuke Hirata
        new int[]{0, 1, 4, 5, 21, 27, 42}, // 8 - Airi Sakura
        new int[]{0, 1, 5, 7, 28, 30}, // 9 - Ken Sudō
        new int[]{0, 3, 4, 11, 22, 41}, // 10 - Hiyori Shiina
        new int[]{0, 1, 3, 4, 10, 22}, // 11 - Mio Ibuki
        new int[]{0, 1, 18, 20}, // 12 - Manabu Horikita
        new int[]{0, 1, 3, 5, 23, 25}, // 13 - Sae Chabashira
        new int[]{0, 6, 15, 16, 23, 40, 45}, // 14 - Professor Ayanokōji
        new int[]{0, 1, 14, 16, 31, 44}, // 15 - Ichika Amasawa
        new int[]{0, 5, 14, 15, 40, 44, 45}, // 16 - Takuya Yagami
        new int[]{0, 2, 3, 6, 33, 34}, // 17 - Kōhei Katsuragi
        new int[]{0, 2, 12, 29, 37}, // 18 - Miyabi Nagumo
        new int[]{0, 1, 3, 12}, // 19 - Rokusuke Kōenji
        new int[]{0, 12, 18}, // 20 - Akane Tachibana
        new int[]{0, 8, 27, 42}, // 21 - Akito Miyake
        new int[]{0, 3, 10, 11}, // 22 - Albert Yamada
        new int[]{0, 6, 13, 14}, // 23 - Chairman Sakayanagi
        new int[]{0, 1, 4, 7}, // 24 - Chiaki Matsushita
        new int[]{0, 2, 6, 13, 43}, // 25 - Chie Hoshinomiya
        new int[]{0, 2, 38}, // 26 - Chihiro Shiranami
        new int[]{0, 8, 21, 42}, // 27 - Haruka Hasebe
        new int[]{0, 1, 5, 9, 30}, // 28 - Haruki Yamauchi
        new int[]{0, 12, 18}, // 29 - Ikuto Kiriyama
        new int[]{0, 9, 28, 39}, // 30 - Kanji Ike
        new int[]{0, 1, 3, 9, 15, 44}, // 31 - Kazuomi Hōsen
        new int[]{0, 1, 5, 6, 16}, // 32 - Kyō Ishigami
        new int[]{0, 3, 6, 17, 34}, // 33 - Masayoshi Hashimoto
        new int[]{0, 6, 17, 33}, // 34 - Masumi Kamuro
        new int[]{0, 4, 7}, // 35 - Maya Satō
        new int[]{0, 4, 7}, // 36 - Mei-Yu Wang
        new int[]{0, 12, 18}, // 37 - Nazuna Asahina
        new int[]{0, 2, 3, 26}, // 38 - Ryūji Kanzaki
        new int[]{0, 4, 9, 30}, // 39 - Satsuki Shinohara
        new int[]{0, 14, 16, 45}, // 40 - Shirō
        new int[]{0, 3, 10, 11}, // 41 - Takeko Nishino
        new int[]{0, 1, 8, 21, 27}, // 42 - Teruhiko Yukimura
        new int[]{0, 2, 13, 17, 25}, // 43 - Tomonari Mashima
        new int[]{0, 14, 15, 16, 31}, // 44 - Tsubasa Nanase
        new int[]{0, 14, 16, 40} // 45 - Yuki
    };

    public static void printAdjacencyList() {
        for (int i = 0; i < characters.length; i++) {
            System.out.print(i + " - " + characters[i] + " - ");
            for (int target : adjacencyList[i]) {
                System.out.print(target + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printAdjacencyList();
    }
}