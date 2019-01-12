import org.scalatest._

class OreoTest extends FlatSpec with Matchers {

  it should "properly parse 'o' to its ASCII representation" in {
    //given:
    val o = "o"
    //when:
    def result = Oreo.toCookieString(o)
    //then:
    result should be ("█")
  }

  it should "properly parse 're' to its ASCII representation" in {
    //given:
    def re = "re"
    //when:
    def result = Oreo.toCookieString(re)
    //then:
    result should be ("  ")
  }

  it should "properly parse 'rere' to its cookie representation" in {
    //given:
    def re = "rere"
    //when:
    def result = Oreo.toCookieString(re)
    //then:
    result should be (" ░░ \n ░░ ")
  }

  it should "properly parse 'oreo' to cookie representation" in {
    //given:
    def string = "oreo"
    //when:
    def result = Oreo.toCookieString(string)
    //then:
      result should be ("████\n" +
        " ░░ \n" +
        "████")
  }

  it should "properly parse 'oreoorererereoo' to cookie representation" in {
    //given:
    def string = "oreoorererereoo"
    //when:
    def result = Oreo.toCookieString(string)
    //then:
      result should be ("███████████████\n ░░░░░░░░░░░░░ \n███████████████\n███████████████\n ░░░░░░░░░░░░░ \n ░░░░░░░░░░░░░ \n ░░░░░░░░░░░░░ \n ░░░░░░░░░░░░░ \n███████████████\n███████████████")
  }

}
