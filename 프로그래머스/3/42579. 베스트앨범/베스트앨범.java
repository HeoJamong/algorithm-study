import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> genrePlayCount = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) + play);
        }

        Map<String, List<int[]>> genreToSongs = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            int[] song = new int[]{i, play};

            if (!genreToSongs.containsKey(genre)) {
                genreToSongs.put(genre, new ArrayList<>());
            }
            genreToSongs.get(genre).add(song);
        }

        ArrayList<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        Collections.sort(sortedGenres, new Comparator<String>() {
            public int compare(String a, String b) {
                return genrePlayCount.get(b) - genrePlayCount.get(a);
            }
        });


        ArrayList<Integer> result = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<int[]> songList = genreToSongs.get(genre);

            Collections.sort(songList, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    if (b[1] == a[1]) {
                        return a[0] - b[0];
                    }
                    return b[1] - a[1];
                }
            });

            result.add(songList.get(0)[0]);
            if (songList.size() > 1) {
                result.add(songList.get(1)[0]);
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
