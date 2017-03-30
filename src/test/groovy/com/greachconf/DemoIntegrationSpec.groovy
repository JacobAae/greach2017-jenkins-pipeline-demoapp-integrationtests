package com.greachconf

import groovyx.net.http.HttpBuilder
import spock.lang.Specification


class DemoIntegrationSpec extends Specification {

    String url = 'http://demo.greach.grydeske.com/'

    void "greeter endpoint have default greeting"() {
        when:
        def httpBin = HttpBuilder.configure {
            request.uri = url
        }
        def result = httpBin.get {
            request.uri.path = '/greeter'
        }

        then:
        result == "Hi Groovy Person, Greach is awesome!"
    }

    void "greeter endpoint greets with name when suplied"() {
        when:
        def httpBin = HttpBuilder.configure {
            request.uri = url
        }
        def result = httpBin.get {
            request.uri.path = '/greeter'
            request.uri.query.name = 'Spain'
        }

        then:
        result == "Hi Spain, Greach is awesome!"
    }
}