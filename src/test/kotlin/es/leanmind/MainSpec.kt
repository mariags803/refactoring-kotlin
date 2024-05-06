package es.leanmind

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

internal class MainSpec : WordSpec({
    "Main" should {
        "fail" {
            1 shouldBe 2
        }
    }
})