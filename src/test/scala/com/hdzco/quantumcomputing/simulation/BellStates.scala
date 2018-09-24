package com.hdzco.quantumcomputing.simulation

import org.scalatest.{FlatSpec, Matchers}
import scala.math.sqrt

class BellStates extends FlatSpec with Matchers {
  import util.EqualityImplicits._

  /**
    * The Bell States are the four states of maximum entanglement for a pair of qubits:
    *   |beta_00> = ( |00> + |11> ) / sqrt(2)
    *   |beta_10> = ( |00> - |11> ) / sqrt(2)
    *   |beta_01> = ( |01> + |10> ) / sqrt(2)
    *   |beta_11> = ( |01> - |10> ) / sqrt(2)
    */

  "The Bell States:" should "have coefs (sqrt(0.5), 0, 0, sqrt(0.5)) for |beta_00>" in {
    val control = Transformation.hadamard(QuantumSystem.Qubit.zero)
    val target  = QuantumSystem.Qubit.zero
    val cnot    = Gate.cnot(control, target)
    val (c1, c2, c3, c4) = cnot.register.parameters
    assert(c1 === sqrt(0.5))
    assert(c2 === 0.0)
    assert(c3 === 0.0)
    assert(c4 === sqrt(0.5))
  }

  it should "have coefs (sqrt(0.5), 0, 0,-sqrt(0.5)) for |beta_10>" in {
    val control = Transformation.hadamard(QuantumSystem.Qubit.one)
    val target  = QuantumSystem.Qubit.zero
    val cnot    = Gate.cnot(control, target)
    val (c1, c2, c3, c4) = cnot.register.parameters
    assert(c1 === sqrt(0.5))
    assert(c2 === 0.0)
    assert(c3 === 0.0)
    assert(c4 === -sqrt(0.5))
  }

  it should "have coefs (0, sqrt(0.5), sqrt(0.5), 0) for |beta_01> " in {
    val control = Transformation.hadamard(QuantumSystem.Qubit.zero)
    val target  = QuantumSystem.Qubit.one
    val cnot    = Gate.cnot(control, target)
    val (c1, c2, c3, c4) = cnot.register.parameters
    assert(c1 === 0.0)
    assert(c2 === sqrt(0.5))
    assert(c3 === sqrt(0.5))
    assert(c4 === 0.0)
  }

  it should "have coefs (0, sqrt(0.5),-sqrt(0.5), 0) for |beta_11>" in {
    val control = Transformation.hadamard(QuantumSystem.Qubit.one)
    val target  = QuantumSystem.Qubit.one
    val cnot    = Gate.cnot(control, target)
    val (c1, c2, c3, c4) = cnot.register.parameters
    assert(c1 === 0.0)
    assert(c2 === sqrt(0.5))
    assert(c3 === -sqrt(0.5))
    assert(c4 === 0.0)
  }
}
