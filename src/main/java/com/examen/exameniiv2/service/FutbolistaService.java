package com.examen.exameniiv2.service;

import com.examen.exameniiv2.domain.Futbolista;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface FutbolistaService {

    void registrarFutbolista(Futbolista futbolista);
    List<Futbolista> listarFutbolistas();
    public Futbolista getFutbolistaById(long id);
    public void save(Futbolista futbolista);
    void deleteViaId(long id);
    List<Futbolista> getAllFutbolistas();
    public Futbolista calcularMasaMuscular(Futbolista futbolista);
    public ArrayList<ArrayList<String>> getFutbolistas();
    public ArrayList<ArrayList<String>> getHistorial();
    public  List<Futbolista> aproxFutbolista (String aprox);
}
