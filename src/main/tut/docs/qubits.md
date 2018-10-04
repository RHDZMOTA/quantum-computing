---
layout: docs
title: qubits
---

# Qubits

## Theory
Quantum bits or qubits for short are the fundamental concept of quantum computation and quantum information. We describe
qubits as *mathematical objects* with certain properties. 

Qubits pure states: 
* $\left\| 0 \right>$ corresponds to the 0 state of a classical bit. 
* $\left\| 1 \right>$ corresponds to the 1 state of a classical bit.

The $\left\| \right>$ notation is called [Dirac notation](). 

The fundamental difference between bits and qubits is that the former can also exist in a [linear combination]()
of the base/pure states, often called superposition: 

$$
\left| \phi \right> = \alpha \left| 0 \right> + \beta \left| 1 \right>
$$

Where $\alpha$ and $\beta$ are complex numbers. In other words: the state of a qubit is a vector in a two-dimensional 
complex vector space. The spacial states $\left\| 0 \right>$ and $\left\| 1 \right>$ are known as *computational basis states*
and form an orthonormal basis for this vector space. Therefore, a qubit can exist in a *continuum* of states between 
$\left\| 0 \right>$ and $\left\| 1 \right>$.

<p style="text-align:center;">
<img src="https://inspirehep.net/record/1242753/files/ComplexCircle.png" alt="qubit-space" align="middle">
</p>

When we measure a qubit we get either $0$ with probability $\| \alpha \|^2$ or $1$ with probability $\| \beta \|^2$. 
Since probabilities must sum up to $1$ therefore: $\| \alpha \|^2 + \| \beta \|^2 = 1$.

**For the reader**: what values of $\alpha$ and $\beta$ make a qubit behave as a fair coin? This state is denoted as $\left\| + \right>$ 

We can express $\alpha$ and $\beta$ of an arbitrary a qubit $\left\| \phi \right>$ as the polar form:

$$
\left| \phi \right> = r_0 e^{i \Phi_0} \left| 0 \right> + r_1 e^{i \Phi_1} \left| 1 \right>
$$

We can factor out the $e^{i \Phi_0}$:

$$
\left| \phi \right> = e^{i \Phi_0} \bigg( r_0 \left| 0 \right> + r_1 e^{i (\Phi_1 - \Phi_0)} \left| 1 \right> \bigg)
$$

By renaming $\Phi = \Phi_1 - \Phi_0$ and considering the normalization constraint we can rewrite into:

$$
\left| \phi \right> = e^{i \Phi_0} \bigg( \cos(\frac{\theta}{2}) \left| 0 \right> + \sin(\frac{\theta}{2}) e^{i \Phi} \left| 1 \right> \bigg)
$$ 

This representation allows us to capture the state of the qubit into two real numbers $0 \leq \theta \pi$ and $0 \leq \Phi \leq 2\pi$.
In essence, a quantum state of a qubit is represented as two normalized complex numbers $\alpha$, $\beta$. Therefore, 
there are 4 different real parameters needed to represent the state. Since one of them does not have a visible effect,
and the other is eliminated by the normalization constraint we are left with $\theta$ and $\Phi$. This numbers define a 
point on the unit three-dimensional sphere often known as the **Block Sphere**:

<p style="text-align:center;">
<img src="https://www.researchgate.net/profile/Fabio_Sebastiano/publication/317573486/figure/fig1/AS:547267548585984@1507490159508/Bloch-sphere-representation-of-a-qubit.png" alt="qubit-space" align="middle" style="width: 20%">
</p>

## Scala Representation

We can represent the computational basis states: 
```tut
import com.hdzco.quantumcomputing.simulation.QuantumSystem

val qubitZero = QuantumSystem.Qubit.zero
val qubitOne  = QuantumSystem.Qubit.one
```

We can collapse an arbitrary $\left\| \phi \right>$ qubit:
```tut
import com.hdzco.quantumcomputing.simulation.{QuantumSystem, Transformation}
import math.sqrt

val qubitPhi = QuantumSystem.Qubit(sqrt(0.7), sqrt(0.3))
println("Probabilities: " + qubitPhi.probabilities)
val qubitPhiCollapsed = Transformation.collapse(qubitPhi)
```

We can expect to estimate the distribution while collapsing a large number of similar qubit configuration: 
```tut
import com.hdzco.quantumcomputing.simulation.{QuantumSystem, Transformation}
import math.sqrt

val qubitList: List[QuantumSystem.Qubit] = List.fill(1000)(QuantumSystem.Qubit(sqrt(0.42), sqrt(0.58)))
val (zero, one) = qubitList.map(q => Transformation.collapse(q).qubit) partition (_.a > 0.90)
println(s"zero-state qubits: ${zero.length / 1000.0} %")
println(s"one-state  qubits: ${one.length / 1000.0} %")
```

Complete example: 
```scala
import com.hdzco.quantumcomputing.simulation.{Gate, QuantumSystem, Transformation}
import math.sqrt

object Example extends App {
  
  val qubitA = QuantumSystem.Qubit.zero // This is a Qubit(1,0)
  val qubitB = QuantumSystem.Qubit.one  // This is a Qubit(0,1)
  val qubitC = QuantumSystem.Qubit.random // This is a phi-state Qubit.
  
  // Create custom qubits
  val qubitPhi = QuantumSystem.Qubit(sqrt(0.7), sqrt(0.3))
  
  // Materialize/collapse qubits
  val collapsed: Transformation.Collapsed = Transformation.collapse(qubitPhi)
  println(collapsed.qubit) // Should be a Collapsed with a Qubit(1,0) or Qubit(0,1)
  
  // Create a list of qubits and count the collapsed results
  val qubitList: List[QuantumSystem.Qubit] = List.fill(1000)(QuantumSystem.Qubit(sqrt(0.9), sqrt(0.1)))
  val (zero, one) = qubitList.map(q => Transformation.collapse(q).qubit) partition (_.a > 0.9)
  println(s"zero-state qubits: ${zero.length / 1000.0} %")
  println(s"one-state  qubits: ${one.length / 1000.0} %")
}
```

**Challenges**
* Change `Double` to `Complex` type for parameters $\alpha$ and $\beta$.
* Typecheck the constraint $\alpha^2 + \beta^2 = 1$
* Representation of the Bloch Sphere. 
