class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            int totalChars = words[index].length();
            int last = index + 1;

            // Try to fit as many words as possible into the line
            while (last < words.length) {
                if (totalChars + 1 + words[last].length() > maxWidth) break;
                totalChars += 1 + words[last].length();
                last++;
            }

            StringBuilder line = new StringBuilder();
            int numberOfWords = last - index;
            int totalSpaces = maxWidth - totalChars + (numberOfWords - 1); // how many extra spaces needed

            // If it's the last line or contains only one word, left-justify
            if (last == words.length || numberOfWords == 1) {
                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i < last - 1) line.append(" ");
                }
                // Fill the rest with spaces
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else {
                // Calculate space distribution
                int spaceSlots = numberOfWords - 1;
                int space = (maxWidth - (totalChars - spaceSlots)) / spaceSlots;
                int extra = (maxWidth - (totalChars - spaceSlots)) % spaceSlots;

                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i < last - 1) {
                        int spacesToApply = space + (i - index < extra ? 1 : 0);
                        for (int s = 0; s < spacesToApply; s++) {
                            line.append(" ");
                        }
                    }
                }
            }

            result.add(line.toString());
            index = last;
        }

        return result;
    }
}