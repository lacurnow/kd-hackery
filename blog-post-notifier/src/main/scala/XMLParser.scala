import scala.io.Source
import scala.xml.XML


// parse XML from file
case class Blog(blogType: String, title: String, xmlUrl: String, htmlUrl: String)

class BlogPostXMLParser {
  def parseXML(blogs: String): Seq[Blog] = {
    val xml = XML.load(blogs)
    xml \\ "outline" map { blog =>
      Blog(
        (blog \\ "@type").text,
        (blog \\ "@title").text,
        (blog \\ "@xmlUrl").text,
        (blog \\ "@htmlUrl").text
      )
    }
  }
}
