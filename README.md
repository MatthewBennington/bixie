![Bixie](https://raw.githubusercontent.com/SRI-CSL/bixie/gh-pages/img/bixie_small.png) Inconsistent Code Detection for Java
=====
[![Build Status](https://travis-ci.org/SRI-CSL/bixie.png)](https://travis-ci.org/SRI-CSL/bixie)
[![Coverage Status](https://coveralls.io/repos/SRI-CSL/bixie/badge.svg?branch=master)](https://coveralls.io/r/SRI-CSL/bixie?branch=master) 

Check our the **[Online Demo](http://csl.sri.com/projects/bixie/)**.

Bixie is a static analysis tool that detects inconsistencies in Java bytecode. An inconsistency occurs if code must throw an exception or is unreachable because because of assumptions made by other statements. 

##### Examples

	 if (operator == null) {
	 	throw new SemanticException("Operator " + operator.getName());
	 }

In this example from Hive, `operator.getName()` is inconsistent with the conditional
`operator == null`. 

In this example from Cassandra:
	
	public Boolean generate() {
		return identityDistribution.next() % 1 == 0;
	}

There is an inconsistency in the bytecode because the expression `identityDistribution.next() % 1 == 0` appears as a conditional choice in the bytecode where one case is unreachable because `identityDistribution.next() % 1` returns a constant value.


#### Build instructions:

Bixie uses gradle to build:

	git clone https://github.com/SRI-CSL/bixie.git
	cd bixie
    ./gradlew shadowJar

#### Usage example:
To check if everything is working, run Bixie on itself:

	cd build/libs/
	java -jar bixie.jar -j ../classes/main/

#### Soundness remarks:
Bixie is not sound. Many Java features, such as concurrency and reflection, are not handled by Bixie and may result in false alarms. Bixie also sometimes detects inconsistencies in the bytecode that have no corresponding inconsistency in the source code. For example, conditional choices with conjunctions in the condition sometimes raise false alarms.






