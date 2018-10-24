package metaprogramming

import groovy.json.JsonSlurper

String.metaClass.pirate = { ->
    String key = new File('pirate_key.txt').text
    String base = 'http://api.funtranslations.com/translate/pirate.json?'
    String qs = "text=${URLEncoder.encode(delegate, 'UTF-8')}&api_key=$key"
    String txt = "$base$qs".toURL().text
    def json = new JsonSlurper().parseText(txt)
    json.contents.translated
}

println "Hello, World!".pirate()
println "How are you today?".pirate()
println "Please fill out your session evals".pirate()
println "I'd like to add you to my professional network on LinkedIn".pirate()