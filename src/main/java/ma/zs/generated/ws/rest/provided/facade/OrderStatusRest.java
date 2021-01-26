package ma.zs.generated.ws.rest.provided.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.zs.generated.bean.OrderStatus;
import ma.zs.generated.service.facade.OrderStatusService;
import ma.zs.generated.ws.rest.provided.converter.OrderStatusConverter;
import ma.zs.generated.ws.rest.provided.vo.OrderStatusVo;

@Api("Manages orderStatus services")
@RestController
@RequestMapping("generated/orderStatus")
public class OrderStatusRest {

    @Autowired
    private OrderStatusService orderStatusService;

    @Autowired
    private OrderStatusConverter orderStatusConverter;

    @ApiOperation("Saves the specified orderStatus")
    @PostMapping("/")
    public OrderStatusVo save(@RequestBody OrderStatusVo orderStatusVo) {
        System.out.println( orderStatusVo);
        orderStatusConverter.setSuperOrderStatus(Boolean.TRUE);
        OrderStatus orderStatus = orderStatusConverter.toItem(orderStatusVo);
        orderStatus = orderStatusService.save(orderStatus);
        return orderStatusConverter.toVo(orderStatus);
    }

    @ApiOperation("Delete the specified orderStatus")
    @DeleteMapping("/")
    public int delete(@RequestBody OrderStatusVo orderStatusVo) {
        OrderStatus orderStatus = orderStatusConverter.toItem(orderStatusVo);
        return orderStatusService.delete(orderStatus);
    }

    @ApiOperation("Updates the specified orderStatus")
    @PutMapping("/")
    public OrderStatusVo update(@RequestBody OrderStatusVo orderStatusVo) {
        orderStatusConverter.setSuperOrderStatus(Boolean.TRUE);
        OrderStatus orderStatus = orderStatusConverter.toItem(orderStatusVo);
        orderStatus = orderStatusService.update(orderStatus);
        return orderStatusConverter.toVo(orderStatus);
    }

    @ApiOperation("Finds a list of all orderStatuss")
    @GetMapping("/")
    public List<OrderStatusVo> findAll() {
        return orderStatusConverter.toVo(orderStatusService.findAll());
    }

    @ApiOperation("Finds a orderStatus by id")
    @GetMapping("/id/{id}")
    public OrderStatusVo findById(@PathVariable Long id) {
        return orderStatusConverter.toVo(orderStatusService.findById(id));
    }

    @ApiOperation("Deletes a orderStatus by id")
    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable Long id) {
        orderStatusService.deleteById(id);
    }

    @ApiOperation("Finds a  orderStatus by code")
    @GetMapping("/code/{code}")
    public OrderStatusVo findByCode(@PathVariable String code) {
        return orderStatusConverter.toVo(orderStatusService.findByCode(code));
    }

    @ApiOperation("Deletes a  orderStatus by code")
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return orderStatusService.deleteByCode(code);
    }


    @ApiOperation("Finds a orderStatus by code of superOrderStatus")
    @GetMapping("/superOrderStatus/code/{code}")
    public List<OrderStatusVo> findBySuperOrderStatusCode(@PathVariable String code) {
        return orderStatusConverter.toVo(orderStatusService.findBySuperOrderStatusCode(code));
    }

    @ApiOperation("Deletes a orderStatus by code of superOrderStatus")
    @DeleteMapping("/superOrderStatus/code/{code}")
    public int deleteBySuperOrderStatusCode(@PathVariable String code) {
        return orderStatusService.deleteBySuperOrderStatusCode(code);
    }

    @ApiOperation("Finds orderStatus by id of superOrderStatus")
    @GetMapping("/superOrderStatus/id/{id}")
    public List<OrderStatusVo> findBySuperOrderStatusId(@PathVariable Long id) {
        return orderStatusConverter.toVo(orderStatusService.findBySuperOrderStatusId(id));
    }

    @ApiOperation("Deletes orderStatus by id of superOrderStatus")
    @DeleteMapping("/superOrderStatus/id/{id}")
    public int deleteBySuperOrderStatusId(@PathVariable Long id) {
        return orderStatusService.deleteBySuperOrderStatusId(id);
    }


    @ApiOperation("Search orderStatus by a specific criterion")
    @PostMapping("/search")
    public List<OrderStatusVo> findByCriteria(@RequestBody OrderStatusVo orderStatusVo) {
        return orderStatusConverter.toVo(orderStatusService.findByCriteria(orderStatusVo));
    }

    public OrderStatusConverter getOrderStatusConverter() {
        return orderStatusConverter;
    }

    public void setOrderStatusConverter(OrderStatusConverter orderStatusConverter) {
        this.orderStatusConverter = orderStatusConverter;
    }

    public OrderStatusService getOrderStatusService() {
        return orderStatusService;
    }

    public void setOrderStatusService(OrderStatusService orderStatusService) {
        this.orderStatusService = orderStatusService;
    }


}