import groovy.json.*



def f = new File('C:\\Users\\mk\\Downloads\\FL_insurance_sample.csv\\FL_insurance_sample.csv')
if (!f.exists()) {
    println("file doesn't exist")
    System.exit(1)
}

def lines = f.readLines()
def keys = lines[0].split(',')
def rows = lines[1..-1].collect { line ->
    def i = 0, vals = line.split(',')
    keys.inject([:]) { map, key -> map << ["$key": vals[i++]] }
}

//println(JsonOutput.toJson(rows))

def jes = new JsonSlurper().parseText(JsonOutput.toJson(lines));


Map
for(name in jes){
    println name.policyID + " " + name.county
}