package ma.zs.generated.ws.rest.provided.converter;

import ma.zs.generated.ws.rest.provided.vo.ProductVo;
import ma.zs.generated.ws.rest.provided.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;


import ma.zs.generated.bean.PricingCollaborator;
import ma.zs.generated.ws.rest.provided.vo.PricingCollaboratorVo;

@Component
public class PricingCollaboratorConverter extends AbstractConverter<PricingCollaborator, PricingCollaboratorVo> {
    private Boolean product;
    private Boolean collaborator;
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private ProductConverter productConverter;

    public PricingCollaboratorConverter() {
        init(true);
    }

    @Override
    public PricingCollaborator toItem(PricingCollaboratorVo vo) {
        if (vo == null) {
            return null;
        } else {
            PricingCollaborator item = new PricingCollaborator();
            if (StringUtil.isNotEmpty(vo.getPriceMax()))
                item.setPriceMax(NumberUtil.toBigDecimal(vo.getPriceMax()));
            if (StringUtil.isNotEmpty(vo.getPrice()))
                item.setPrice(NumberUtil.toBigDecimal(vo.getPrice()));
            if (StringUtil.isNotEmpty(vo.getPriceMin()))
                item.setPriceMin(NumberUtil.toBigDecimal(vo.getPriceMin()));
            if (StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
            if (vo.getProduct() != null && this.product)
                item.setProduct(productConverter.toItem(vo.getProduct()));
            if (vo.getCollaborator() != null && this.collaborator)
                item.setCollaborator(userConverter.toItem(vo.getCollaborator()));


            return item;
        }
    }

    @Override
    public PricingCollaboratorVo toVo(PricingCollaborator item) {
        if (item == null) {
            return null;
        } else {
            PricingCollaboratorVo vo = new PricingCollaboratorVo();

            if (item.getPriceMax() != null)
                vo.setPriceMax(NumberUtil.toString(item.getPriceMax()));
            if (item.getPrice() != null)
                vo.setPrice(NumberUtil.toString(item.getPrice()));
            if (item.getPriceMin() != null)
                vo.setPriceMin(NumberUtil.toString(item.getPriceMin()));
            if (item.getId() != null)
                vo.setId(NumberUtil.toString(item.getId()));
            if (item.getProduct() != null && this.product)
                vo.setProduct(productConverter.toVo(item.getProduct()));
            if (item.getCollaborator() != null && this.collaborator)
                vo.setCollaborator(userConverter.toVo(item.getCollaborator()));

            return vo;

        }
    }

    public void init(Boolean value) {
    }

	public Boolean getProduct() {
		return product;
	}

	public void setProduct(Boolean product) {
		this.product = product;
	}

	public Boolean getCollaborator() {
		return collaborator;
	}

	public void setCollaborator(Boolean collaborator) {
		this.collaborator = collaborator;
	}

	public UserConverter getUserConverter() {
		return userConverter;
	}

	public void setUserConverter(UserConverter userConverter) {
		this.userConverter = userConverter;
	}

	public ProductConverter getProductConverter() {
		return productConverter;
	}

	public void setProductConverter(ProductConverter productConverter) {
		this.productConverter = productConverter;
	}
}