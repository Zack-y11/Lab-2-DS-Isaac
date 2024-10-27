package org.example.common
import org.example.common.Node

class Queue <T>{
    private var front:Node<T>? = null
    private var rear:Node<T>? = null
    private var size = 0

    fun enqueue(value: T) {
        val newNode = Node(value)
        if (rear != null) {
            rear?.next = newNode
        }
        rear = newNode
        if (front == null) {
            front = rear
        }
        size++
    }

    fun dequeue(): T? {
        if (isEmpty()) {
            println("Queue is empty.")
            return null
        }
        val dequeuedValue = front?.value
        front = front?.next
        if (front == null) {
            rear = null
        }
        size--
        return dequeuedValue
    }
    fun peek(): T? {
        return front?.value
    }
    fun isEmpty(): Boolean {
        return front == null
    }
    fun size () : Int{
        return size
    }
    override fun toString(): String {
        if (isEmpty()) return "[]"
        val result = StringBuilder("[")
        var current = front
        while (current != null) {
            result.append(current.value)
            if (current.next != null) {
                result.append(", ")
            }
            current = current.next
        }
        result.append("]")
        return result.toString()
    }

    fun forEach(action: (T) -> Unit) {
        var current = front
        while (current != null) {
            action(current.value)
            current = current.next
        }
    }
}