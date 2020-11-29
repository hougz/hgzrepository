package com.hgz.product.serviceImpl;

import com.hgz.pojo.TbProduct;
import com.hgz.pojo.TbProductExample;
import com.hgz.product.dao.ProductMapper;
import com.hgz.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductMapper productMapper;

    @Override
    public int countByExample(TbProductExample example) {
        return productMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(TbProductExample example) {
        return productMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TbProduct record) {
        return productMapper.insert(record);
    }

    @Override
    public int insertSelective(TbProduct record) {
        return productMapper.insertSelective(record);
    }

    @Override
    public List<TbProduct> select(TbProductExample example) {
        return productMapper.selectByExample(example);
    }

    @Override
    public TbProduct selectByPrimaryKey(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(TbProduct record, TbProductExample example) {
        return productMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(TbProduct record, TbProductExample example) {
        return productMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(TbProduct record) {
        return productMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TbProduct record) {
        return productMapper.updateByPrimaryKey(record);
    }
}
