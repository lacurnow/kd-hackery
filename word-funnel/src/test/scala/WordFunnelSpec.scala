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

import org.scalatest.{BeforeAndAfterAll, FlatSpec, Matchers}

class WordFunnelSpec extends FlatSpec with Matchers with BeforeAndAfterAll {
  behavior of "WordFunnel"

  it should "return an array of words where one of the letters in missing" in {
    //bodacious, 9
    val expected = Array[String]("odacious", "bdacious", "boacious", "bodcious", "bodaious", "bodacous",
    "bodacius", "bodacios", "bodaciou")

    val actual = WordFunnel.wordsWithMissingLetter("bodacious", Array[String]())

    actual should contain theSameElementsAs(expected)
  }

  it should "return true if the second word can be made from the first by removing one letter" in {
    val expected = true

    val actual = WordFunnel.funnel("leave", "eave")

    actual shouldEqual(expected)
  }

  it should "return true if the second word can be made from the first word (with duplicate letters) by removing one letter" in {
    val expected = true

    val actual = WordFunnel.funnel("dragoon", "dragon")

    actual shouldEqual(expected)
  }

  it should "return false if the second word contains the first word" in {
    val expected = false

    val actual = WordFunnel.funnel("eave", "leave")

    actual shouldEqual(expected)
  }

  it should "return false if the second word is made by removing more than one letter" in {
    val expected = false

    val actual = WordFunnel.funnel("skiff", "ski")

    actual shouldEqual(expected)
  }

  it should "find real words that can be made from dragon, removing one letter" in {

    val expected = Array[String]("dragon")

    val missingLetterWords = WordFunnel.wordsWithMissingLetter("dragoon", Array[String]())

    val actual = WordFunnel.findRealWords(missingLetterWords, "src/main/scala/real_words_list.txt")

    // actual.map(word => println(word))

    actual should contain theSameElementsAs(expected)
  }

  it should "find real words that can be made from boats, removing one letter" in {

    val expected = Array[String]("oats", "bats", "bots", "boas", "boat")

    val missingLetterWords = WordFunnel.wordsWithMissingLetter("boats", Array[String]())

    val actual = WordFunnel.findRealWords(missingLetterWords, "src/main/scala/real_words_list.txt")

    actual.map(word => println(word))

    actual should contain theSameElementsAs(expected)
  }

  it should "return empty array if no real words can be made" in {

    val expected = Array[String]()

    val missingLetterWords = WordFunnel.wordsWithMissingLetter("affidavit", Array[String]())

    val actual = WordFunnel.findRealWords(missingLetterWords, "src/main/scala/real_words_list.txt")

    actual.map(word => println(word))

    actual should contain theSameElementsAs(expected)
  }
}
