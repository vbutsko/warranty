package by.warranty.addon.facades.catalogs.converters.populator;


import by.warranty.addon.facades.product.data.WarrantyData;
import by.warranty.addon.model.WarrantyModel;
import de.hybris.platform.catalog.model.CatalogModel;
import de.hybris.platform.commercefacades.catalog.CatalogOption;
import de.hybris.platform.commercefacades.catalog.converters.populator.CatalogHierarchyPopulator;
import de.hybris.platform.commercefacades.catalog.data.CatalogData;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Required;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WarrantyCatalogHierarchyPopulator extends CatalogHierarchyPopulator
{

    private Converter<WarrantyModel, WarrantyData> warrantyConverter;

    @Override
    public void populate(final CatalogModel source, final CatalogData target,  final Collection<CatalogOption> options)
            throws ConversionException
    {
        super.populate(source, target, options);
        final List<WarrantyData> warrantyDataList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(source.getWarranties()))
        {
            for(final WarrantyModel warranty: source.getWarranties())
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
