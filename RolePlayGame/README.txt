RolePlayGame, an introduction to Customer Test-Driven Development and FitNesse
* see http://davenicolette.wikispaces.com/TDD+Randori+and+Fishbow
* see http://www.fitnesse.org

[for Java, with ANT]
1. build and test the project:
	ant
2. start fitnesse, by default on localhost port 80:
	cd fitnesse
	./run.sh
3. open the fitnesse homepage:
	http://localhost:80
4. in the "Projects" section, click on "RolePlayGame" link
5. click the "Suite" upper-left button
6. enjoy!

[for .NET, with NANT]
1. on Linux and MacOS, you need MONO (see http://www.mono-project.com). then, execute:
	chmod a+x fitnesse/FitServer
2. to build, run:
	nant
3. run fitnesse and open browser (see 2..6 above)
