package by.warranty.addon.facades.product.converters.populator;

import by.warranty.addon.facades.product.data.WarrantyData;
import by.warranty.addon.model.WarrantyModel;
import de.hybris.platform.commercefacades.product.converters.populator.ProductPopulator;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Required;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class WarrantyProductPopulator extends ProductPopulator
{

    private Converter<WarrantyModel, WarrantyData> warrantyConverter;

    @Override
    public void populate(final ProductModel source, final ProductData target)
    {
        super.populate(source, target);
        final List<WarrantyData> warrantyDataList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(source.getWarranties()))
        {
            for(final WarrantyModel warranty: source.getWarranties())
            {
                warrantyDataList.add(warrantyConverter.convert(warranty));
            }
        }
        else if (CollectionUtils.isNotEmpty(source.getCatalogVersion().getCatalog().getWarranties()))
        {
            for(final WarrantyModel warranty: source.getCatalogVersion().getCatalog().getWarranties())
            {
                warrantyDataList.add(warrantyConverter.convert(warranty));
            }
        }
        target.setWarranties(warrantyDataList);
    }

    @Required
    public void setWarrantyConverter(final Converter<WarrantyModel, WarrantyData> warrantyConverter)
    {
        this.warrantyConverter = warrantyConverter;
    }
}
