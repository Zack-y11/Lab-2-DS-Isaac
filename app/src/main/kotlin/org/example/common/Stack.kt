package org.example.common

data class Node<T>(var value: T, var next: Node<T>? = null)

class Stack<T> {
    private var top: Node<T>? = null
    private var size: Int = 0

    fun push(value: T) {
        val newNode = Node<T>(value, top)
        top = newNode
        size++
    }

    fun peek(): T?{
        return top?.value
    }

    fun isEmpty(): Boolean{
        return size == 0
    }
    fun pop(): T? {
        if(isEmpty()) return null

        val poppedValue = top?.value
        top = top?.next
        size--

        return poppedValue
    }

    override fun toString(): String {
        if(isEmpty()) return "[]"

        val sb = StringBuilder("[")
        var pivot = top
        while(pivot !== null){
            sb.append(pivot.value)
            pivot = pivot.next

            if(pivot !== null){
                sb.append(", ")
            }
        }
        sb.append("]")
        return sb.toString()
    }
    fun forEach(action: (T) -> Unit) {
        var current = top
        while (current != null) {
            action(current.value)
            current = current.next
        }
    }
}