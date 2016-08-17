package quoteParser

/**
 * Created by Pavel.Zhuk on 16.08.2016.
 */
data class Content(val body: List<String>,
                   val header: QuoteHeader?,
                   val quote: Content?) {

    fun toString(addMarks: Boolean = false): String {
        val prefix = if (addMarks) "> " else ""
        val separator = if (addMarks) "\n> " else "\n"

        return StringBuilder(body.joinToString(separator = "\n", postfix = "\n"))
                .append(header?.text?.joinToString(prefix = prefix, separator = separator, postfix = "\n") ?: "")
                .append(quote?.body?.joinToString(prefix = prefix, separator = separator, postfix = "\n") ?: "")
                .toString()
    }

    override fun toString(): String {
        return StringBuilder(body.joinToString(separator = "\n", postfix = "\n"))
                .append(header?.text?.joinToString(prefix = "", separator = "\n", postfix = "\n") ?: "")
                .append(quote?.body?.joinToString(prefix = "", separator = "\n", postfix = "\n") ?: "")
                .toString()
    }
}