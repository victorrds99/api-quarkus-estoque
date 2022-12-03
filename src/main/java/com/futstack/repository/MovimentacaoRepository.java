package com.futstack.repository;



import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.futstack.Model.ConteudoMensagem;
import com.futstack.Model.Deposito;
import com.futstack.Model.Fornecedor;
import com.futstack.Model.Movimentacao;
import com.futstack.Model.Produto;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishResponse;

@ApplicationScoped
public class MovimentacaoRepository implements PanacheRepository<Movimentacao>{
    

    @Inject
    SnsClient client;

    @ConfigProperty(name = "topic.arn", defaultValue = "arn:aws:sns:us-east-1:399093640054:Quarkus")
    String topicArn;

    public PublishResponse mandaSmsEmail(ConteudoMensagem request){
        var conteudoMensagem = new ConteudoMensagem();
        conteudoMensagem.setAssuntoMensagem(request.getAssuntoMensagem());
        conteudoMensagem.setMensagem(request.getMensagem());
        PublishResponse resposta = client.publish(p -> 
            p.message(conteudoMensagem.getMensagem())
            .topicArn(topicArn)
            .subject(conteudoMensagem.getAssuntoMensagem()));
        return resposta;
    }

    public void registraCriacaoDeposito(Deposito dto){
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setMo_tipo("Novo Deposito foi criado!! id: "+ dto.getDe_id() + ", nome: "+ dto.getDe_nome() + " !!");
        movimentacao.persist();

        //manda sms
        var req = new ConteudoMensagem();
        req.setAssuntoMensagem("Criação de deposito!");
        req.setMensagem("Foi criado um novo deposito com nome de: "+ dto.getDe_nome());
        var resposta = mandaSmsEmail(req);
        
    }

    public void registraAlteracaoDeposito(Deposito dto){
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setMo_tipo("Nova Alteração nos dados do Deposito de id: "+ dto.getDe_id() + ", nome: "+ dto.getDe_nome()  + " !!");
        movimentacao.persist();

                //manda sms
                var req = new ConteudoMensagem();
                req.setAssuntoMensagem("Alteração de deposito!");
                req.setMensagem("Foi alterado um novo deposito com nome de: "+ dto.getDe_nome());
                var resposta = mandaSmsEmail(req);
    }
    public void registraExclusaoDeposito(Deposito dto){
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setMo_tipo("Nova Exclusao do Deposito de id: "+ dto.getDe_id() + ", nome: "+ dto.getDe_nome() + " !!");
        movimentacao.persist();

                //manda sms
                var req = new ConteudoMensagem();
                req.setAssuntoMensagem("Exclusão de deposito!");
                req.setMensagem("Foi excluido um novo deposito com nome de: "+ dto.getDe_nome());
                var resposta = mandaSmsEmail(req);
    }

    

    public void registraCriacaoProduto(Produto dto){
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setMo_tipo("Novo Produto foi criado!! id: "+ dto.getPr_id() + ", nome: "+ dto.getPr_nome() + ", categoria: " + dto.getPr_categoria() + " !!");
        movimentacao.persist();

                //manda sms
                var req = new ConteudoMensagem();
                req.setAssuntoMensagem("Criação de produto!");
                req.setMensagem("Foi criado um novo produto com nome de: "+ dto.getPr_nome() + ", categoria: " + dto.getPr_categoria() );
                var resposta = mandaSmsEmail(req);
    }
    public void registraAlteracaoProduto(Produto dto){
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setMo_tipo("Nova Alteração nos dados do Produto de id: "+ dto.getPr_id() + ", nome: "+ dto.getPr_nome() + ", categoria: " + dto.getPr_categoria() + " !!");
        movimentacao.persist();

        //manda sms
        var req = new ConteudoMensagem();
        req.setAssuntoMensagem("Alteração de produto!");
        req.setMensagem("Foi alterado um novo produto com nome de: "+ dto.getPr_nome() + ", categoria: " + dto.getPr_categoria() );
        var resposta = mandaSmsEmail(req);
    }
    public void registraExclusaoProduto(Produto dto){
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setMo_tipo("Nova Exclusao do Produto de id: "+ dto.getPr_id() + ", nome: "+ dto.getPr_nome() + ", categoria: " + dto.getPr_categoria() + " !!");
        movimentacao.persist();

        //manda sms
        var req = new ConteudoMensagem();
        req.setAssuntoMensagem("Exclusão de produto!");
        req.setMensagem("Foi excluido um novo produto com nome de: "+ dto.getPr_nome() + ", categoria: " + dto.getPr_categoria() );
        var resposta = mandaSmsEmail(req);
    }


    

    public void registraCriacaoFornecedor(Fornecedor dto){
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setMo_tipo("Novo Fornecedor foi criado!! id: "+ dto.getFo_id() + ", nome: "+ dto.getFo_nome() + " !!");
        movimentacao.persist();

        //manda sms
        var req = new ConteudoMensagem();
        req.setAssuntoMensagem("Criação de fornecedor!");
        req.setMensagem("Foi criado um novo fornecedor com nome de: "+ dto.getFo_nome() );
        var resposta = mandaSmsEmail(req);
    }
    
    public void registraAlteracaoFornecedor(Fornecedor dto){
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setMo_tipo("Nova Alteração nos dados do Fornecedor de id: "+ dto.getFo_id() + ", nome: "+ dto.getFo_nome() + " !!");
        movimentacao.persist();

        //manda sms
        var req = new ConteudoMensagem();
        req.setAssuntoMensagem("Alteração de fornecedor!");
        req.setMensagem("Foi alterado um novo fornecedor com nome de: "+ dto.getFo_nome() );
        var resposta = mandaSmsEmail(req);
    }
    
    public void registraExclusaoFornecedor(Fornecedor dto){
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setMo_tipo("Nova Exclusao do Fornecedor de id: "+ dto.getFo_id() + ", nome: "+ dto.getFo_nome() + " !!");
        movimentacao.persist();

        //manda sms
        var req = new ConteudoMensagem();
        req.setAssuntoMensagem("Exclusão de fornecedor!");
        req.setMensagem("Foi excluido um novo fornecedor com nome de: "+ dto.getFo_nome() );
        var resposta = mandaSmsEmail(req);
    }
    



    public void registraAdicaoProdutoNoDeposito(Deposito depositoObjeto, Produto produtoObjeto){

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setMo_tipo("Deposito com id: "+ depositoObjeto.getDe_id() + ", nome: "+ depositoObjeto.getDe_nome() + " adicinoou o produto de id: " + produtoObjeto.getPr_id() + " e nome: " + produtoObjeto.getPr_nome());
        movimentacao.persist();

        //manda sms
        var req = new ConteudoMensagem();
        req.setAssuntoMensagem("Adição no deposito");
        req.setMensagem("Deposito com id: "+ depositoObjeto.getDe_id() + ", nome: "+ depositoObjeto.getDe_nome() + " adicinoou o produto de id: " + produtoObjeto.getPr_id() + " e nome: " + produtoObjeto.getPr_nome() );
        var resposta = mandaSmsEmail(req);
    }

    

    public void registraSubtracaoProdutoNoDeposito(Deposito depositoObjeto, Produto produtoObjeto){

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setMo_tipo("Deposito com id: "+ depositoObjeto.getDe_id() + ", nome: "+ depositoObjeto.getDe_nome() + " removeu o produto de id: " + produtoObjeto.getPr_id() + " e nome: " + produtoObjeto.getPr_nome());
        movimentacao.persist();

        //manda sms
        var req = new ConteudoMensagem();
        req.setAssuntoMensagem("Subtração no deposito");
        req.setMensagem("Deposito com id: "+ depositoObjeto.getDe_id() + ", nome: "+ depositoObjeto.getDe_nome() + " removeu o produto de id: " + produtoObjeto.getPr_id() + " e nome: " + produtoObjeto.getPr_nome() );
        var resposta = mandaSmsEmail(req);

    }
    

    public void registrAdicaoProdutoNF(Produto dto){
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setMo_tipo("Novo Produto foi criado!! id: "+ dto.getPr_id() + ", nome: "+ dto.getPr_nome() + ", categoria: " + dto.getPr_categoria() + " !!");
        movimentacao.persist();
    }

  

    
}

