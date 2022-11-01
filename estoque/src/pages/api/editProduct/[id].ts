import axios from 'axios';
import { NextApiRequest, NextApiResponse } from 'next';

const editProdut = async (req: NextApiRequest, res: NextApiResponse) => {
  const { id } = req.query;

  if (req.method === 'PUT') {
    const bodyData = {
      pr_nome: req.body.pr_nome,
      pr_preco: req.body.pr_preco,
      pr_quantidade: req.body.pr_quantidade,
      pr_categoria: req.body.pr_categoria,
      pr_reposicao: req.body.pr_reposicao,
      pr_pont_repo: Number(req.body.pr_quantidade) < Number(req.body.pr_reposicao),
    };

    try {
      const { data } = await axios.put(`http://my-quarkus-app:8080/produto/${id}`, bodyData, {
        headers: {
          accept: 'application/json',
        },
      });

      return res.status(200).json(data);
    } catch (error) {
      return res.status(500).send('Internal server error');
    }
  }

  res.setHeader('Allow', 'PUT');
  return res.status(405).end('Method not allowed');
};

export default editProdut;
