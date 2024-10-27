package org.example.common
import org.example.common.Stack
import org.example.common.CustomList
import org.example.common.Queue

data class Pupusa(val type: String, val amount: Int) {
    override fun toString(): String {
        return "$amount de $type" // Por ejemplo, "3 de Revuelta"
    }
}

data class Order(val client: String, val pupusas: CustomList<Pupusa>) {
    override fun toString(): String {
        val pupusasStr = StringBuilder()
        pupusas.forEachIndexed { index, pupusa ->
            if (index > 0) pupusasStr.append(", ")
            pupusasStr.append(pupusa)
        }
        return "$client: ${pupusasStr.toString()}"
    }
}

class ControlOrders{
    private val pendingOrders = Queue<Order>()
    private val dispatchedOrders = Stack<Order>()

    fun registerOrder(client: String, tipoPupusas: CustomList<Pupusa>) {
        pendingOrders.enqueue(Order(client, tipoPupusas))
        val pupusas = pupusaDetails(tipoPupusas)
        println("Orden registrada para $client: $pupusas")
    }

    fun showOrders() {
        if (pendingOrders.isEmpty()) {
            println("No hay órdenes pendientes")
        } else {
            println("Órdenes pendientes:")
            pendingOrders.forEach { order ->
                println(order)
            }
        }
    }
    fun dispatchedOrder(){
        val orden = pendingOrders.dequeue() ?: return println("No hay ordenes pendientes")
        dispatchedOrders.push(orden)
        val pupusasStr = pupusaDetails(orden.pupusas)
        println("Despachando la orden de: ${orden.client}: $pupusasStr")
    }

    fun showDispatchedOrder(){
        if(dispatchedOrders.isEmpty()){
            println("No hay ordenes que despachar")
        }else{
            println("Ordenes Despachadas: ")
            dispatchedOrders.forEach { order -> println(order) }
        }
    }

    fun pupusaDetails(pupusas: CustomList<Pupusa>):StringBuilder {
        val pupusasStr = StringBuilder()
        pupusas.forEachIndexed { index, pupusa ->
            if (index > 0) pupusasStr.append(", ")
            pupusasStr.append(pupusa)
        }
        return pupusasStr
    }
}




