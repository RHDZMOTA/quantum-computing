---
layout: page
title: "Nomenclature and notation"
section: "nomenclature"
position: 2
---

# Nomenclature and Notation

Two level quantum systems are used as qubits usually with a zero state $\left\| 0 \right>$ that represents the 
column vector $(1,0)$ and a one state $\left\| 1 \right>$ that represents the column vector $(0,1)$.

A **probability distribution** is a finite set of real numbers $p_x$ such that $0 \leq p_x$ and $\sum_x p_x = 1$.


## Quantum gates and circuit symbols 

* Hadamard

$$
\frac{1}{\sqrt{2}} \begin{bmatrix}1 & 1\\1 & -1\end{bmatrix}
$$

* Pauli-X

$$
\begin{bmatrix}0 & 1\\1 & 0\end{bmatrix}
$$

* Pauli-Y

$$
\begin{bmatrix}0 & -i\\i & 0\end{bmatrix}
$$

* Pauli-Z

$$
\begin{bmatrix}1 & 0\\0 & -1\end{bmatrix}
$$

* Phase

$$
\begin{bmatrix}1 & 0\\0 & i\end{bmatrix}
$$

* $\pi / 8$

$$
\begin{bmatrix}1 & 0\\0 & e^{i \pi / 4}\end{bmatrix}
$$


* controlled-NOT

$$
\begin{bmatrix}1 & 0 & 0 & 0\\0 & 1 & 0 & 0\\0 & 0 & 0 & 1\\0 & 0 & 1 & 0\end{bmatrix}
$$

* Swap


$$
\begin{bmatrix}1 & 0 & 0 & 0\\0 & 0 & 1 & 0\\0 & 1 & 0 & 0\\0 & 0 & 0 & 1\end{bmatrix}
$$

* controlled-Z

$$
\begin{bmatrix}1 & 0 & 0 & 0\\0 & 1 & 0 & 0\\0 & 0 & 1 & 0\\0 & 0 & 0 & -1\end{bmatrix}
$$

* controlled-phase

$$
\begin{bmatrix}1 & 0 & 0 & 0\\0 & 1 & 0 & 0\\0 & 0 & 1 & 0\\0 & 0 & 0 & i\end{bmatrix}
$$

* Toffoli

* Fredkin (controlled-swap)

* measurement

* classical bit

* $n$ qubits