clean:
	rm -rf build/
	rm -f *.java~ Makefile~ *.sh~

compiler: creation.sh
	./$^ build
	javac -d build/ -cp build/ src/*.java
	javac -d build/ -cp build/ tst/*.java
tester_1:compiler
	javac -d build/ -cp build/ tst/TestPosition.java
	javac -d build/ -cp build/ tst/TestJauge.java
tester_2:compiler
	javac -d build/ -cp build/ tst/TestPassagerStandard.java
	javac -d build/ -cp build/ tst/TestAutobus.java

tester: tester_1 tester_2
	java -ea -cp build/ tec.TestPosition
	java -ea -cp build/ tec.TestJauge
	java -ea -cp build/ tec.TestAutobus
	java -ea -cp build/ tec.TestPassagerStandard
	rm -rf src/*.java~ && rm -rf tst/*.java~
global:clean compiler #compilation seulement.
#pas de package tec au debut de simple=>pas introduction dans build/tec.*.
#mais -d en premier important sinon rien.($(executer))
	javac -d build/ -cp build/ SimpleAbstract.java
DIRBUILD?=build
executer:$(DIRBUILD)
	java -cp build/ SimpleAbstract

global2: clean compiler
	javac -d build/ -cp build/ SimpleIndecis.java
executer2: $(DIRBUILD)
	java -cp build/ SimpleIndecis

global3: clean compiler
	javac -d build/ -cp build/ SimpleStresse.java
executer3: $(DIRBUILD)
	java -cp build/ SimpleStresse



#-cp indique le chemin.
