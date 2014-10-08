package pelagaggemodel.jr;


import java.util.Vector;
import pelagaggemodel.pojo.Recibo;

/**
 *
 * @author arturo
 */
public class JasperReportDataSourceFactory {
    
    private static int dsType; //si es 1:reciboBean, else vect...
    private static Recibo reciboBean;
    private static Vector<Recibo> vectorReciboBean;
    
    public JasperReportDataSourceFactory(){};
    
    public JasperReportDataSourceFactory (Recibo r){
        reciboBean=r;
        dsType=1;
    }
    
    public JasperReportDataSourceFactory(Vector<Recibo> recibos){
        vectorReciboBean=recibos;
        dsType=2;
    }
    
    public Vector getDS(){
        return getReciboDataSource();
    }
      
    public static Vector getReciboDataSource(){
        
        Vector datasource=new Vector();
        
        if (dsType==1){
        datasource.add(reciboBean);}
        else{
            for (Recibo r:vectorReciboBean){
                datasource.add(r);
            }
        }
        
        return datasource;

    }
    
}
