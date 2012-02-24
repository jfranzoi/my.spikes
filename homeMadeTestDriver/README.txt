Here's the code from my "Home-made test driver" session!

"What do I need?"
* java 1.5
* ant
* mysql running locally
* (optional) eclipse, for browsing source code

"How do I play with this?"
* check mysql configuration in build.xml file ("mysql.opts" property)
* list all available ant targets, with 
	ant -p
* you'll probably need to setup mysql first, with
	ant db.init
* build, test and run application locally using default ant target, with
	ant
* you could then point your browser at local URL shown in ant output message
(by default, "http://localhost:8080")

have fun!
