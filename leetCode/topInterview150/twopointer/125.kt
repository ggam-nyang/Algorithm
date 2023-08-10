package leetCode.topInterview150.twopointer

/**
 * Alphanumeric 생성 후 Palindrome 체크를 했다.
 * 효율적 방법: String 생성하지 않고, Alphanumeric character만 check 하도록 하자.
 */
class Solution125 {
    fun isPalindrome(s: String): Boolean {
        val alphaString= getLowerCaseAlphanumeric(s)

        return checkPalindrome(alphaString)
    }

    private fun checkPalindrome(alphaString: String): Boolean {
        if (alphaString.isEmpty()) return true

        for (i in 0..alphaString.lastIndex / 2) {
            if (alphaString[i] != alphaString[alphaString.lastIndex - i]) return false
        }
        return true
    }

    private fun getLowerCaseAlphanumeric(s: String): String {
        val nonAlphaNum = "[^a-zA-Z0-9]".toRegex()
        return s.replace(nonAlphaNum, "").toLowerCase()
    }
}