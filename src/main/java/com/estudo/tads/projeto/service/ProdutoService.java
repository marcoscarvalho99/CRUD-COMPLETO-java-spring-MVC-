package com.estudo.tads.projeto.service;

import com.estudo.tads.projeto.Dao.ProdutoRepository;
import com.estudo.tads.projeto.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public List<Produto> findall() {
        return produtoRepository.findAll();
    }

    public void add(Produto produto) {

        produtoRepository.save(produto);
    }

    public Produto getOne(Long id) {
        return produtoRepository.getOne(id);
    }

    public void delete(Long id) {

        produtoRepository.deleteById(id);
    }


}
