package mx.com.diegoA.control.Icontrol;

import java.util.ArrayList;

/**
 *
 * @author Dies
 */
public interface IAccionesDB {

    boolean Agregar(Object O);

    boolean Editar(Object O);

    boolean ConsultaSimple(Object O);

    boolean Eliminar(Object O);

    ArrayList<Object> ConsultaCompleja();

    ArrayList<Object> ConsultaCompleja(Object O);

    ArrayList<Object> ConsultaEspecializada(Object O);
    ArrayList<Object> ConsultaEspecializada2(Object O, Object _obj2);

    int ConsultarUltimo();

    ArrayList<Object> ConsultaParaManager(Object O);

}
