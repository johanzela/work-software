/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajo;

/**
 *
 * @author leoch
 */
public class Cola {
    private final Habitacion[] habitaciones;
    private int frente; // Índice del frente de la cola
    private int fin; // Índice del final de la cola
    private final int capacidad; // Capacidad máxima de la cola
    private int size; // Tamaño actual de la cola

    public Cola(int capacidad) {
        this.capacidad = capacidad;
        this.habitaciones = new Habitacion[capacidad];
        this.frente = 0;
        this.fin = -1;
        this.size = 0;
    }

    public boolean estaVacia() {
        return size == 0;
    }

    public boolean estaLlena() {
        return size == capacidad;
    }

    public int getSize() {
        return size;
    }

    public void encolar(Habitacion habitacion) {
        if (!estaLlena()) {
            fin = (fin + 1) % capacidad;
            habitaciones[fin] = habitacion;
            size++;
        } else {
            System.out.println("La cola está llena. No se puede encolar.");
        }
    }
    public void encolarHabitacion(int numero, int camas, int piso, double precio, String estado) {
        Habitacion habitacion = new Habitacion(numero, camas, piso, precio, estado);
        encolar(habitacion);
    }
    

    public Habitacion desencolar() {
        if (!estaVacia()) {
            Habitacion habitacion = habitaciones[frente];
            frente = (frente + 1) % capacidad;
            size--;
            return habitacion;
        } else {
            System.out.println("La cola está vacía. No se puede desencolar.");
            return null;
        }
    }


    public Habitacion desapilar() {
        if (!estaVacia()) {
            int index = (frente + size - 1) % capacidad;
            Habitacion habitacion = habitaciones[index];
            size--;
            return habitacion;
        } else {
            System.out.println("La cola está vacía. No se puede desapilar.");
            return null;
        }
    }
    
    public void modificarDatosHabitacion(int numeroHabitacion, int camas, int piso, double precio, String estado) {
        int index = encontrarHabitacionXnumero(numeroHabitacion);
        if (index != -1) {
            Habitacion habitacion = new Habitacion(numeroHabitacion, camas, piso, precio, estado);
            habitaciones[index] = habitacion;
        } else {
            System.out.println("No se encontró la habitación con el número especificado en la cola.");
        }
    }
    
    public void modificarEstadoHabitacion(int numeroHabitacion, String nuevoEstado) {
        int index = encontrarHabitacionXnumero(numeroHabitacion);
        if (index != -1) {
            Habitacion habitacion = habitaciones[index];
            habitacion.setEstado(nuevoEstado);
        } else {
            System.out.println("No se encontró la habitación con el número especificado en la cola.");
        }
    }
    
    public boolean existeHabitacionConNumero(int numeroHabitacion) {
        int index = encontrarHabitacionXnumero(numeroHabitacion);
        return index != -1;
    }
    
    private int encontrarHabitacionXnumero(int numeroHabitacion) {
        int index = frente;
        for (int i = 0; i < size; i++) {
            if (habitaciones[index].getNumero() == numeroHabitacion) {
                return index;
            }
            index = (index + 1) % capacidad;
        }
        return -1;
    }
    
    public String HabitacionesPorEstado(String estado) {
        StringBuilder sb = new StringBuilder();
        int index = encontrarHabitacionXestado(estado);
        if (index != -1) {
            sb.append("Habitaciones con estado \"").append(estado).append("\" :\n");
            sb.append("\nN°habitación\t Cant.camas\t Piso\t Precio x día\t Estado \n");
            int currentIndex = index;
            int count = 0;
            while (count < size) {
                Habitacion habitacion = habitaciones[currentIndex];
                if (habitacion != null && habitacion.getEstado().equals(estado)) {
                    sb.append(habitacion).append("\n");
                }
                currentIndex = (currentIndex + 1) % capacidad;
                count++;
            }
            sb.append("\n");
        } 
        return sb.toString();
    }

    private int encontrarHabitacionXestado(String estado) {
        int index = frente;
        for (int i = 0; i < size; i++) {
            if (habitaciones[index].getEstado().equals(estado)) {
                return index;
            }
            index = (index + 1) % capacidad;
        }
        return -1;
    }
    
    public double calcularImporteTotalEnUso() {
        double importeTotalEnUso = 0.0;
        int index = frente;
        for (int i = 0; i < size; i++) {
            Habitacion habitacion = habitaciones[index];
            if (habitacion != null && habitacion.getEstado().equals("En Uso")) {
                importeTotalEnUso += habitacion.getPrecio();
            }
            index = (index + 1) % capacidad;
        }
        return importeTotalEnUso;
    }

    public double calcularImporteTotalDisponibles() {
        double importeTotalDisponibles = 0.0;
        int index = frente;
        for (int i = 0; i < size; i++) {
            Habitacion habitacion = habitaciones[index];
            if (habitacion != null && habitacion.getEstado().equals("Disponible")) {
                importeTotalDisponibles += habitacion.getPrecio();
            }
            index = (index + 1) % capacidad;
        }
        return importeTotalDisponibles;
    }
    
    public void ordenarPorPiso() {
        int n = size;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (habitaciones[j].getPiso() < habitaciones[minIndex].getPiso()) {
                    minIndex = j;
                }
            }
            swap(i, minIndex);
        }
    }

    // Método de ordenamiento por selección para ordenar por estado
    public void ordenarPorEstado() {
        int n = size;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (habitaciones[j].getEstado().compareTo(habitaciones[minIndex].getEstado()) < 0) {
                    minIndex = j;
                }
            }
            swap(i, minIndex);
        }
    }

    private void swap(int i, int j) {
        Habitacion temp = habitaciones[i];
        habitaciones[i] = habitaciones[j];
        habitaciones[j] = temp;
    }
    
    private Cola crearCopiaCola() {
        Cola copiaCola = new Cola(capacidad);
        int index = frente;
        for (int i = 0; i < size; i++) {
            copiaCola.encolar(habitaciones[index]);
            index = (index + 1) % capacidad;
        }
        return copiaCola;
    }

    // Método para imprimir el reporte de habitaciones ordenadas por piso
    public String reportePorPiso() {
        Cola copiaCola = crearCopiaCola();
        copiaCola.ordenarPorPiso();
        return copiaCola.mostrarCola();
    }

    // Método para imprimir el reporte de habitaciones ordenadas por estado
    public String reportePorEstado() {
        Cola copiaCola = crearCopiaCola();
        copiaCola.ordenarPorEstado();
        return copiaCola.mostrarCola();
    }

    public String mostrarCola() {
        StringBuilder sb = new StringBuilder();
        if (!estaVacia()) {
            sb.append("Reporte de Habitaciones: \n");
            sb.append("\nN°habitación\t Cant.camas\t Piso\t Precio x día\t Estado \n");
            int index = frente;
            for (int i = 0; i < size; i++) {
                sb.append(habitaciones[index]).append("\n");
                index = (index + 1) % capacidad;
            }
            sb.append("\n");
        } else {
            sb.append("La cola está vacía.");
        }
        return sb.toString();
    }
}
