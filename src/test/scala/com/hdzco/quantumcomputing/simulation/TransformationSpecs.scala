package com.hdzco.quantumcomputing.simulation

import org.scalatest.{FlatSpec, Matchers}

import scala.math.sqrt

class TransformationSpecs extends FlatSpec with Matchers {
  import util.EqualityImplicits._
  def sum(tuple: (Double, Double)): Double = tuple._1 + tuple._2

  "A Hadamard transformation" should "return a Qubit(sqrt(0.5), sqrt(0.5))  for a Qubit.zero" in {
    val qubitIn  = QuantumSystem.Qubit.zero
    val qubitOut = Transformation.hadamard(qubitIn)
    val qubitExpected  = QuantumSystem.Qubit(sqrt(0.5), sqrt(0.5))
    assert(sum(qubitOut.probabilities) === 1.0)
    assert(qubitOut === qubitExpected)
  }

  it should "return a Qubit(sqrt(0.5), -sqrt(0.5)) for a Qubit.one" in {
    val qubitIn  = QuantumSystem.Qubit.one
    val qubitOut = Transformation.hadamard(qubitIn)
    val qubitExpected = QuantumSystem.Qubit(sqrt(0.5), -sqrt(0.5))
    assert(sum(qubitOut.probabilities) === 1.0)
    assert(qubitOut === qubitExpected)
  }

  it should "return a Qubit.zero for a Hadamard transform of a Qubit.zero" in {
    val qubitIn  = QuantumSystem.Qubit.zero
    val qubitOut = Transformation.hadamard(Transformation.hadamard(qubitIn))
    val qubitExpected = QuantumSystem.Qubit.zero
    assert(sum(qubitOut.probabilities) === 1.0)
    assert(qubitOut === qubitExpected)
  }

  it should "return a Qubit.one  for a Hadamard transform of a Qubit.one" in {
    val qubitIn  = QuantumSystem.Qubit.one
    val qubitOut = Transformation.hadamard(Transformation.hadamard(qubitIn))
    val qubitExpected = QuantumSystem.Qubit.one
    assert(sum(qubitOut.probabilities) === 1.0)
    assert(qubitOut === qubitExpected)
  }
}
