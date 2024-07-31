object BlogPostNotifier {
  def main(arg: Array[String]): Unit = {
    val blogPostXMLParser = new BlogPostXMLParser
    val blogs = blogPostXMLParser.parseXML("./src/main/resources/blogs.xml")
    blogs .foreach { blog =>
      println(s"New blog post: ${blog.title}")
    }
  }
}
