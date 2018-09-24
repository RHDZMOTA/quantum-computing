# Quantum Computing

This repository contains some notes regarding quantum computation. 
The main objective of this software is to generate a data model in the form of 
library components that best represents (simulates) quantum objects using the 
[Scala programming language](https://www.scala-lang.org/). 



## Requirements

You'll need at least the following software dependencies in order to run this examples:
* **Java 8** or superior.
    * For debian-based systems: `sudo apt install openjdk-8-jdk`
* Scala Build Tool ([SBT](https://www.scala-sbt.org/index.html))
    * Download for all platforms [here](https://www.scala-sbt.org/download.html). 

If you are using Windows 10, we recommend running this software on the 
Windows Subsystem for Linux ([WSL](https://docs.microsoft.com/en-us/windows/wsl/install-win10)).

## Usage

You can run the provided examples on the `examples` package. 
* **Quantum Entanglement with Bell State 00**
    * `sbt "run com.hdzco.quantumcomputing.simulation.examples.BellEntanglement"`


### Standalone Example

```scala
import com.hdzco.quantumcomputing.simulation.{Gate, QuantumSystem, Transformation}

object Example extends App {
  
  val qubitA = QuantumSystem.Qubit.zero // This is a Qubit(1,0)
  val qubitB = QuantumSystem.Qubit.one  // This is a Qubit(0,1)
  val qubitC = QuantumSystem.Qubit.random // This is a phi-state Qubit.
  
  // Create custom qubits
  val qubitD = QuantumSystem.Qubit(0.7, 0.3)
  
  // Materialize/collapse qubits
  val collapsed: Transformation.Collapsed = Transformation.collapse(qubitD)
  println(collapsed.qubit) // Should be Qubit(1,0) or Qubit(0,1)
  
  // Create a list of qubits and count the collapsed results
  val qubitList: List[QuantumSystem.Qubit] = List.fill(10000)(QuantumSystem.Qubit(0.9, 0.1))
  val (zero, one) = qubitList.map(q => Transformation.collapse(q).qubit) partition (_.a > 0.9)
  println(s"zero-state qubits: ${zero.length / 10000.0} %")
  println(s"one-state  qubits: ${one.length / 10000.0} %")
}

```

## Tests

The tests are used in order to evaluate the correctness of the program. We try to evaluate 
the derived properties of the software with common examples. 

Relevant tests: 

* **Bell States Test** 
    * `src/test/scala/com/hdzco/quantumcomputing/simulation/BellStates.scala` 
    
## Authors and contributions
Feel free to contribute to this project. Open a PR or an issue if needed. 

Contact the authors for more information:
* [Daniel Hernández Mota](https://www.linkedin.com/in/daniel-hern%C3%A1ndez-mota-b57b66148/)
* [Rodrigo Hernández Mota](https://linkedin.com/in/rhdzmota)

## License

See the **LICENSE.md** file. 