package inc.evil.coursecatalog.web

import inc.evil.coursecatalog.utils.WebIntegrationTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient

@WebIntegrationTest
internal class GreetingControllerIntegrationTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Test
    fun retrieveGreeting() {
        val name = "Mike"
        val result = webTestClient.get()
            .uri("/api/v1/greetings/{name}", name)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().is2xxSuccessful
            .expectBody(SuccessResponse::class.java)
            .returnResult()

        assertThat(result.responseBody?.response).isNotNull.isEqualTo("Hi there, Mike!")
    }

}
