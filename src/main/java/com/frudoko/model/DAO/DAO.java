package com.frudoko.model.DAO;



public interface DAO <T> {

    // crud

    //create
  public boolean save (T item );

    
    // read
    public T getbyId (int id );


    // update
    public boolean edit (T item);

    // delete
    public boolean delete (int id );



    //    public List<T> getAll ( );
}
