String.metaClass.pirate = { ->
    String base = 'http://isithackday.com/arrpi.php?'
    String qs = "text=${URLEncoder.encode(delegate, 'UTF-8')}"
    "$base$qs".toURL().text
}

println "Hello, World!".pirate()
println "How are you today?".pirate()
println "Please fill out your session evals".pirate()
println "Thanks Tim Yates for the URL recommendation".pirate()