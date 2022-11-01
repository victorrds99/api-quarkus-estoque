import axios from 'axios';
import { NextApiRequest, NextApiResponse } from 'next';
import { ProvidersProps } from '../../context/useQuarkus';

const login = async (req: NextApiRequest, res: NextApiResponse) => {
  if (req.method === 'GET') {
    try {
      const { data } = await axios.get<ProvidersProps[]>('http://my-quarkus-app:8080/login', {
        headers: {
          accept: 'application/json',
        },
      });

      return res.status(200).json(data);
    } catch (error) {
      return res.status(500).send(error);
    }
  }

  res.setHeader('Allow', 'GET');
  return res.status(405).end('Method not allowed');
};

export default login;
