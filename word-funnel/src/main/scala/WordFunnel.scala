import scala.annotation.tailrec
import scala.io.Source

/*
Given two strings,
determine whether the second can be made from the first by removing a letter.
The remaining letters must stay in the same order.
Examples:
funnel("leave", "eave") => true
funnel("reset", "rest") => true
funnel("dragoon", "dragon") => true
funnel("eave", "leave") => false
funnel("sleet", "lets") => false
funnel("skiff", "ski") => false
 */


object WordFunnel {

  @tailrec
  def wordsWithMissingLetter(firstWord: String, missinLetterWords: Array[String], acc: Int = 0): Array[String] = {
    if (acc == firstWord.length) {
      missinLetterWords
    } else {
      val nextWord = firstWord.toList.updated(acc, "").mkString("")
      wordsWithMissingLetter(firstWord, missinLetterWords :+ nextWord, acc + 1)
    }
  }

  def funnel(firstWord: String, secondWord: String): Boolean = {
    val acceptableWords = wordsWithMissingLetter(firstWord, Array[String]())
    acceptableWords.contains(secondWord)
  }

  def findRealWords(missingLetterWords: Array[String], realLetterWordsFile: String): Array[String] = {
    val realWordArray = openFile(realLetterWordsFile)
    missingLetterWords intersect(realWordArray)
  }

  def openFile(filename: String): Array[String] = {
    val dataSource = Source.fromFile(filename)
    val lines: String = dataSource.mkString
    dataSource.close
    lines.split("\n")
  }
}