import groovy.json.JsonSlurper

String.metaClass.pirate = { ->
    //String base = 'http://isithackday.com/arrpi.php?'
    String base = 'http://api.funtranslations.com/translate/pirate.json?'
    String qs = "text=${URLEncoder.encode(delegate, 'UTF-8')}"
    String txt = "$base$qs".toURL().text
    def json = new JsonSlurper().parseText(txt)
    json.contents.translated
}

println "Hello, World!".pirate()
println "How are you today?".pirate()
println "Please fill out your session evals".pirate()
println "I'd like to add you to my professional network on LinkedIn".pirate()