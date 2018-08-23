
package br.com.senac.agenda.dao;

import java.util.List;

public abstract class DAO <T> {
    public abstract void salvar (T objeto);
    public abstract void deletar (T objeto);
    public abstract List<T> listar();
    public abstract T get (int id);
    
    
}
