package com.evol.pichincha.controlador;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.evol.pichincha.entidad.TipoCambio;
import com.evol.pichincha.enums.NombreEntidadEnum;
import com.evol.pichincha.servicio.TipoCambioServicio;

@RestController
@RequestMapping("/tipoCambio")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class TipoCambioControlador extends BaseControladorImpl<TipoCambio, Long> implements BaseControlador<TipoCambio, Long> {

    @Autowired
    private TipoCambioServicio tipoCambioServicio;
    
    @Autowired
    public TipoCambioControlador(TipoCambioServicio tipoCambioServicio) {
        super(tipoCambioServicio, NombreEntidadEnum.TIPO_CAMBIO.getValor());
    }

    @PostMapping("procesarTipoDeCambio")
    public Map<String, Object> procesarTipoDeCambio(@RequestParam(value = "monto", required = false) Double monto,
                                            @RequestParam(value = "monedaOrigenId", required = false) Long monedaOrigenId,
                                            @RequestParam(value = "monedaDestinoId", required = false) Long monedaDestinoId) {
        
        Map<String, Object> paramsMap = tipoCambioServicio.procesarTipoDeCambio(monto, monedaOrigenId, monedaDestinoId);
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("monto: " + monto);
        System.out.println("monedaOrigenId: " + monedaOrigenId);
        System.out.println("monedaDestinoId: " + monto);
        System.out.println("");
        System.out.println("");
        System.out.println("");

        return paramsMap;
    }
}
