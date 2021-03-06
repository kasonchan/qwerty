import org.junit.runner._
import org.scalatest.junit.JUnitRunner
import org.specs2.mutable._
import play.api.test.Helpers._
import play.api.test._
import play.api.test.WithApplication

/**
  * Add your spec here.
  * You can mock out a whole application including requests, plugins etc.
  * For more information, consult the wiki.
  */
@RunWith(classOf[JUnitRunner])
class ApplicationSpec extends Specification {

  "Application" should {

    "render the index page" in new WithApplication {
      val home = route(FakeRequest(GET, "/")).get

      status(home) must equalTo(OK)
      contentType(home) must beSome.which(_ == "text/html")
      contentAsString(home) must contain("shouts out")
    }
  }

}
