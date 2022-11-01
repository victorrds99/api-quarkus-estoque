import axios from 'axios';
import { NextApiRequest, NextApiResponse } from 'next';

const addProductInDeposit = async (req: NextApiRequest, res: NextApiResponse) => {
  const { param } = req.query;
  if (req.method === 'PUT') {
    try {
      const { data } = await axios.put(`http://my-quarkus-app:8080/service/deposito/${param[0]}/produto/${param[1]}${param[2] ? `/${param[2]}` : ''}`, {
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

export default addProductInDeposit;
