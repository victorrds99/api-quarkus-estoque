import axios from 'axios';
import { NextApiRequest, NextApiResponse } from 'next';
import { DepositsProps } from '../../context/useQuarkus';

const getMovements = async (req: NextApiRequest, res: NextApiResponse) => {
  if (req.method === 'GET') {
    try {
      const { data } = await axios.get<DepositsProps[]>('http://my-quarkus-app:8080/movimentacao', {
        headers: {
          accept: 'application/json',
        },
      });

      return res.status(200).json(data);
    } catch (error) {
      return res.status(500).send('Internal server error');
    }
  }

  res.setHeader('Allow', 'GET');
  return res.status(405).end('Method not allowed');
};

export default getMovements;
