---
layout: home
title: "Quantum Computing"
section: "home"
position: 1
---
# Quantum Computing

This site aims to provide an introduction to the main ideas behind quantum computing as well as representing 
them in a Scala Domain Specific Language (DSL). 

## Why Quantum Computing

Or in other words: **Why reinventing computing?** 

### Short Answer

While classical computers can solve a huge set of problems there are still some interesting problems left unsolved in 
both practical and theoretical sense. Some common examples involve [optimization]() and [simulation](). Most of these problems have in common the [exponential scaling]() effect. 
This effect can make a complex problem practically unsolvable when certain size is reached due to 
the computational power needed. Quantum computation offers a solution leveraging the physical phenomena of 
[superposition](https://www.youtube.com/watch?v=8kyJfAC4VAo) and [entanglement](https://www.youtube.com/watch?v=RmXasxLm43k). 
This enable quantum computing to also scale exponentially as the problem's size increases. 

<p style="text-align:center;">
<img src="https://www.researchgate.net/profile/Jashan_Singhal/publication/309653719/figure/fig1/AS:424491617656832@1478218096511/A-qubit-in-Hilbert-space-in-its-SU2-representation-top-and-the-same-qubit-on-the.png" alt="qubit" style="width: 50%"/>
</p>

Image credits [here](https://www.researchgate.net/profile/Jashan_Singhal/publication/309653719/figure/fig1/AS:424491617656832@1478218096511/A-qubit-in-Hilbert-space-in-its-SU2-representation-top-and-the-same-qubit-on-the.png).

### Long Answer 

Hardware development took off in 1947 with the invention of the [transistor](https://en.wikipedia.org/wiki/Transistor).
Since then, computing power has been following [Moore's Law](https://en.wikipedia.org/wiki/Moore%27s_law) (i.e. roughly doubling every two years). 
Nonethless, this trend is expected to end in the first two decades of the twenty-first century due to fundamental 
difficulties regarding the size of transistors (quantum effects begin to interfere with classical computing architectures). 

One possible solution to continue with the Moore's Law is to change the computing paradigm onto one capable of taking 
advantage of quantum systems. In essence, using quantum mechanics to perform computations instead of classical physics. 

<p style="text-align:center;">
<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/9d/Moore%27s_Law_Transistor_Count_1971-2016.png/1200px-Moore%27s_Law_Transistor_Count_1971-2016.png" alt="moore" style="width: 50%"/>
</p>

The idea of a [Turing Machine](https://en.wikipedia.org/wiki/Turing_machine) proposed by Alan Turing in 1936 lead to the
following thesis:
> Any algorithmic process can be simulated efficiently using a turing machine. 

Where the measure of "efficiency" is mathematically defined by the field of computational complexity. 

A more general form of this thesis contemplates randomized algorithms that can efficiently solve problems that are 
inefficiently solved by deterministic computing:
> Any algorithmic process can be simulated efficiently using a probabilistic turing machine. 

<p style="text-align:center;">
<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Universal_Turing_machine.svg/1200px-Universal_Turing_machine.svg.png" alt="turing" style="width: 50%"/>
</p>

With this thesis, one would think that we could efficiently simulate a quantum system. Nonetheless, it has been shown 
that trying to simulate a quantum system with a classical computer is far from efficient (in a mathematical sense). 
Many experts speculate that there is no conceivable amount of progress in classical computation that would be able to
overcome the gap between classical computing and the power of quantum computing. 

In this regard, David Deutsch in 1985 defined a computational device that would be capable of efficiently simulating 
an arbitrary physical system based on the laws of physics. This device was then known as the **Universal Quantum Computer**. 
This quantum computer challenged the Church-Turing thesis because it could efficiently solve computational problems 
which have no efficient solution with probabilistic turing machines. 

Mathematically proved examples: 
* Finding the prime factors of an integer.
* The discrete logarithm problem.
* Search over an unstructured space.

Nonetheless, designing and implementing quantum algorithms remains a hard problem!

---
For more information:
* [A Beginner’s Guide To Quantum Computing by Talia Gershon](https://www.youtube.com/watch?v=JRIPV0dPAd4)
* [Quantum Computing by IBM](https://www.ibm.com/blogs/research/2017/09/qc-how-it-works/)

## Why Scala 

The [Scala Programming Language](https://www.scala-lang.org/) offers a combination of [Object Oriented Programming]() 
and [Functional Programming](). We consider that this model in combination with a strong type system best suites the 
representation of quantum objects in a simulation environment. Moreover, Scala is known for it's ability to create 
DSLs (domain specific languages) and parallelism support. 

* **Object Oriented Programming** enables us to create modular code and identify key 
components of the theory as entities. 
* **Functional Programming** allows us to write clean and maintainable code by following
the rules of immutability, pure functions, composition and more. Also, the implementation 
* **DSL**s facilitate the representation of the quantum-theory in the application logic. 
* **Parallelism** makes more efficient to perform computing intensive simulations.  

## Requirements

To follow along with the theory we recommend:
* Strong knowledge about **linear algebra**. 
* Familiarity with advanced concepts of **computer science**, **physics** and **calculus**. 

To run the examples you'll need:
* **Java 8** or greater.
    * For debian-based systems: `sudo apt install openjdk-8-jdk`
* Scala Build Tool ([SBT](https://www.scala-sbt.org/index.html))
    * Download for all platforms [here](https://www.scala-sbt.org/download.html). 

If you are using Windows 10, we recommend running this software on the 
Windows Subsystem for Linux ([WSL](https://docs.microsoft.com/en-us/windows/wsl/install-win10)).

## Structure

This notes rely heavily on the book [Quantum Computation and Quantum Information by Mchael A. Nielsen & Issac L. Chuang](https://www.amazon.com/Quantum-Computation-Information-10th-Anniversary/dp/1107002176).

## References

add references