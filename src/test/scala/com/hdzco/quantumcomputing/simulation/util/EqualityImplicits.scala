package com.hdzco.quantumcomputing.simulation.util

import com.hdzco.quantumcomputing.simulation.QuantumSystem
import org.scalactic.{Equality, TolerantNumerics, TripleEquals}

object EqualityImplicits {
  import TripleEquals._
  implicit val doubleEquality: Equality[Double] = TolerantNumerics.tolerantDoubleEquality(0.0001)
  implicit val qubitEquality: Equality[QuantumSystem.Qubit] = new Equality[QuantumSystem.Qubit] {
    override def areEqual(a: QuantumSystem.Qubit, b: Any): Boolean = b match {
      case q: QuantumSystem.Qubit => a.a === q.a && a.b === q.b // TODO: test entangled qubit
      case _ => false
    }
  }
}
