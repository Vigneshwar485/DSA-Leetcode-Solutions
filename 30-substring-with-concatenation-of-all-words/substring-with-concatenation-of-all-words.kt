class Solution {
    
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        // Length Variables
        val wordLength = words[0].length
        val totalWordLength = wordLength * words.size
        val n = s.length

        // Result list
        val result = ArrayList<Int>()

        // Word frequency map
        val wordsWithCount = hashMapOf<String, Int>()
        for (word in words) {
            wordsWithCount[word] = wordsWithCount.getOrDefault(word, 0) + 1
        }

        // Sliding window approach with multiple start positions
        // E.g for s = "barfoothefoobarman", words = ["foo","bar"]
        // Iteration 0 will start from 'b'
        // Iteration 1 will start from 'a'
        // Iteration 2 will start from 'r'
        // Rest of the iterations are not required, as it is already covered by sliding window.
        for (offset in 0 until wordLength) {
            var start = offset
            val seenMap = hashMapOf<String, Int>()
            val queue = LinkedList<String>()

            while (start + wordLength <= n) {
                val currentWord = s.substring(start, start + wordLength)

                if (wordsWithCount.containsKey(currentWord)) {
                    // Adding word to queue and updating seenMap.
                    queue.offer(currentWord)
                    seenMap[currentWord] = seenMap.getOrDefault(currentWord, 0) + 1

                    // If count exceeds expected, removing the excess words from front.
                    while (seenMap[currentWord]!! > wordsWithCount[currentWord]!!) {
                        val removedWord = queue.poll()
                        seenMap[removedWord] = seenMap[removedWord]!! - 1
                    }

                    // If valid substring is found, adding that index to the result
                    if (queue.size == words.size) {
                        result.add(start - totalWordLength + wordLength)
                    }
                } else {
                    // Reset the window when encountering an invalid word
                    queue.clear()
                    seenMap.clear()
                }
                // Moving to the next word position
                start += wordLength
            }
        }
        return result
    }
}