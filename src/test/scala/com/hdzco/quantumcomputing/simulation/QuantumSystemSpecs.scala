package com.hdzco.quantumcomputing.simulation

import org.scalatest.{FlatSpec, Matchers}

class QuantumSystemSpecs extends FlatSpec with Matchers {
  import util.EqualityImplicits._
  def sum(tuple: (Double, Double)): Double = tuple._1 + tuple._2

  "A Qubit.zero" should "be a Qubit(1,0)" in {
    val qubitTest = QuantumSystem.Qubit.zero
    val qubitExpected = QuantumSystem.Qubit(1, 0)
    assert(qubitTest === qubitExpected)
  }

  it should "have a probability distr that sums to 1" in {
    val qubitTest = QuantumSystem.Qubit.zero
    assert(sum(qubitTest.probabilities) === 1.0)
  }

  "A Qubit.one" should "be a Qubit(0,1)" in {
    val qubitTest = QuantumSystem.Qubit.one
    val qubitExpected = QuantumSystem.Qubit(0,1)
    assert(qubitTest === qubitExpected)
  }

  it should "have a probability distr that sums to 1" in {
    val qubitTest = QuantumSystem.Qubit.one
    assert(sum(qubitTest.probabilities) === 1.0)
  }

  "A random state qubit (phi)" should "have a probability distr that sum to 1" in {
    val nTests = 1000
    val randomPhiQubits: List[QuantumSystem.Qubit] = List.fill(nTests)(QuantumSystem.Qubit.random)
    assert(randomPhiQubits.map(qubit => sum(qubit.probabilities) === 1.0).forall(_ == true))
  }
}
