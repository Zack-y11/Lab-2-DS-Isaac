package org.example.common
import org.example.common.Node

class CustomList<T> {
    private var head: Node<T>? = null
    private var size = 0

    fun size(): Int {
        return size
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun forEachIndexed(action: (index: Int, T) -> Unit) {
        var current = head
        var index = 0
        while (current != null) {
            action(index, current.value)
            current = current.next
            index++
        }
    }

    fun add(value: T) {
        val newNode = Node(value)
        if (head == null) {
            head = newNode
        } else {
            var current = head
            while (current?.next != null) {
                current = current.next
            }

            current?.next = newNode
        }
        size++
    }

    fun get(idx: Int): T? {
        if (idx < 0 || idx >= size) {
            throw IndexOutOfBoundsException("Index out of range ${idx}")
        }

        var current = head
        var currentIdx = 0

        while (currentIdx < idx) {
            current = current?.next
            currentIdx++
        }

        return current?.value
    }

    fun remove(idx: Int): T? {
        if (idx < 0 || idx >= size) {
            throw IndexOutOfBoundsException("Index out of range ${idx}")
        }

        val removed: T?
        if (idx == 0) {
            val current = head
            head = head?.next

            removed = current?.value
        } else {

            var current = head
            var currentIdx = 1

            while (currentIdx < idx) {
                current = current?.next
                currentIdx++
            }

            removed = current?.next?.value
            current?.next = current?.next?.next

            return removed
        }
        size--
        return removed
    }

    override fun toString(): String {
        if (isEmpty()) return "[]"

        val result = StringBuilder("[")
        var current = head
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

}